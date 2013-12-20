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

icon_normal_el_file = "plugin_icon_el_normal.png"
icon_normal_el_file_content = "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"

icon_pressed_el_file = "plugin_icon_el_pressed.png"

icon_normal_file = "plugin_icon_normal.png"
icon_normal_file_content = "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"

icon_pressed_file = "plugin_icon_pressed.png"
icon_pressed_file_content = "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"

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
create_binary_file(os.path.join(drawable_directory, icon_normal_file), icon_normal_file_content.decode('base64'))
create_binary_file(os.path.join(drawable_directory, icon_pressed_file), icon_pressed_file_content.decode('base64'))
create_binary_file(os.path.join(drawable_directory, icon_normal_el_file), icon_normal_el_file_content.decode('base64'))
create_binary_file(os.path.join(drawable_directory, icon_pressed_el_file), icon_pressed_file_content.decode('base64'))
copy_file(os.path.join('..', 'bin', 'atoomasdk.jar'), os.path.join(libs_directory, 'atoomasdk.jar'))

