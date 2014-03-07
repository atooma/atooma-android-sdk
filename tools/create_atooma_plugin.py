#!/usr/bin/env python

import os, sys, shutil, argparse

parser = argparse.ArgumentParser(description="Create a new Atooma plugin project with specified name and destination.")

#TODO
#parser.add_argument("sdk_root", help="The path to the `sdk` directory.")

parser.add_argument("plugin_name", help="The project is created in a directory of this name.")
parser.add_argument("destination", help="The path to the destination directory.", nargs='?', default="./")

args = parser.parse_args()

plugin_name = args.plugin_name.lower().title()
dest_folder = args.destination

if not os.path.exists(dest_folder):
    print "Destination path doesn't exist!"
    exit(0)

folder = os.path.join(dest_folder, "Atooma%sPlugin" % plugin_name)
package = "com.atooma.plugin.%s" % plugin_name.lower()
strings_file = "strings.xml"
strings_file_content = """
<resources>
    <string name="app_name">%sPlugin</string>
    <string name="module_name">%s</string>
</resources>""" % (plugin_name, plugin_name)

module_file = "%s.java" % plugin_name.upper()
module_file_content = """
package %s;

import android.content.Context;
import com.atooma.plugin.Module;

public class %s extends Module {
    
    public static final String MODULE_ID = "%s";
    public static final int MODULE_VERSION = 1;

    public %s(Context context, String id, int version) {
        super(context, id, version);
    }
    
    @Override
    public void registerComponents() {
        //Register your components here!
    }
    
    @Override
    public void defineUI() {
        setIcon(R.drawable.plugin_icon_normal, R.drawable.plugin_icon_pressed);
        setTitle(R.string.module_name);
    }

    @Override
    public void defineAuth() {
        //Get the username autenticated from activity and define it with setAuthenticated(true, authText);
    }

    @Override
    public void clearCredentials() {
        //Clear
    }
    
}""" % (package, plugin_name.upper(), plugin_name.upper(), plugin_name.upper())

#REGISTRATION RECEIVER
receiver_class = "%sReceiver" % plugin_name.upper()
receiver_file = "%s.java" % receiver_class
receiver_file_content = """
package %s;

import com.atooma.sdk.AtoomaRegistrationReceiver;

public class %sReceiver extends AtoomaRegistrationReceiver {

    @Override
    public Class getRegisterServiceClass() {
        return %sRegister.class;
    }

}
""" % (package, plugin_name.upper(), plugin_name.upper())

#REGISTER SERVICE
register_class = "%sRegister" % plugin_name.upper()
register_file = "%s.java" % register_class
register_file_content = """
package %s;

import com.atooma.plugin.Module;
import com.atooma.sdk.RegisterService;

public class %sRegister extends RegisterService {
    @Override
    public Module getModuleInstance() {
        return new %s(this, %s.MODULE_ID, %s.MODULE_VERSION);
    }
}
""" % (package, plugin_name.upper(), plugin_name.upper(), plugin_name.upper(), plugin_name.upper())

manifest_file = "AndroidManifest.xml"
manifest_file_content = """
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="%s"
    android:versionCode="1"
    android:versionName="1.0" >

    <uses-sdk
        android:minSdkVersion="9"
        android:targetSdkVersion="17" />

    <application
        android:allowBackup="true">
        <service
            android:name="com.atooma.AtoomaService"
            android:process=":remote" />

        <receiver android:name=".%s" >
            <intent-filter>
                <action android:name="com.atooma.plugin.REGISTRATION" />
            </intent-filter>
        </receiver>

        <service android:name=".%s" android:process=":remote"/>
    </application>

</manifest>
""" % (package, receiver_class, register_class)

def create_directory(path):
    if not os.path.exists(path):
        os.makedirs(path)  

def create_file(path, content, mode='w'):
    file = open(path, mode)
    file.write(content)
    file.close()

def create_binary_file(path, content):
    create_file(path, content, 'wb')

def copy_file(path_src, path_dest):
    shutil.copyfile(path_src, path_dest)

bin_directory = os.path.join(folder, 'bin')
create_directory(bin_directory)
res_directory = os.path.join(folder, 'res')
create_directory(res_directory)
values_directory = os.path.join(res_directory, 'values')
create_directory(values_directory)
drawable_directory = os.path.join(res_directory, 'drawable')
create_directory(drawable_directory)
libs_directory = os.path.join(folder, 'libs')
create_directory(libs_directory)
src_directory = os.path.join(folder, 'src')
for directory in package.split('.'):
    src_directory = os.path.join(src_directory, directory)
    create_directory(src_directory)
create_file(os.path.join(src_directory, module_file), module_file_content)
create_file(os.path.join(src_directory, register_file), register_file_content)
create_file(os.path.join(src_directory, receiver_file), receiver_file_content)
create_file(os.path.join(folder, manifest_file), manifest_file_content)
create_file(os.path.join(values_directory, strings_file), strings_file_content)
copy_file(os.path.join('..', 'bin', 'atoomasdk.jar'), os.path.join(libs_directory, 'atoomasdk.jar'))

