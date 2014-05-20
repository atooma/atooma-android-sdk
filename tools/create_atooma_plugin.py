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

icon_normal_file = "plugin_icon_normal.png"
icon_normal_file_content = "iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAYAAADDPmHLAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH3gUUDxwkIlNm9gAAAotJREFUeNrt3TFyUzEUhWH7jnbAYijSULGgNCkoGAqKNFkQFU0KFsMaTM8wg+1n+13pfP8CEknnv0dKJhkfT6fTAbmUIyAAghlbv8Dvj9/abert9f0u99rzy9Ox214//Pq6rwCrhn3u9+ooxfICPDL0S9YyowxD6NkyDKFnyzAE/7j9dBRhCD5bhCH4bBFK+Nl7H4LPboMSfnYbDMFnt0EJP7sNSvjZEgzBZ18JJfzsNijhZ0tQws+WoISfLUEJP1uCEn62BP4qOJzj1n8M+fLzs+nfke+ffhx3awDh78/WDEr42RJ4A4RTpj+7BUr42RK4AlwBpj+5BUr42RK4AlwBpj+5BTSABjD9yS2gATSA6U9uAQ2gAUAA9R97DWgADQACqP/Ya0ADaAAQQP3HXgMaQAOAACAACOABGPgQ1AAaAAQAAUAAEAAEAAFAABAABAABQAAQAAQAAUAAEAAEAAFAAKwmwNZPn0B//s5YA2gAEAAEAAE8BMMegBoABCDAmVWB9epfA4AABLiwMrBO/WsAEIAAV1YH5q9/DYD/C6AF1p1+DYDzBNACa06/BsD5AmiB9ab/4gYgwVrhuwJwuQBaYJ3pv7oBSLBG+K4AXC+AFph/+jc3AAnmDv8mV8DzyxMJduIWZ+8N4A3Qw0Tsc+bVbUF47FlX14XhMWdc3ReI+55tzbJQ4d/nTGu2BQv/toxHLPzt9d0nkjYdolplI8JvLAAJ+p7V2GNjroQ+Q1IpGxV+gwbQBv2GodIPIH3vo9NBpLRBJ+lHx4NZVYSObTc6H9QqInS+5sYsBzebDLO8bcaMB9pVhhkftOMwIZ1kmP2nmHGYnH8FcC8pVvyR9Xg6+a1sMv4qmABI5g+LcEd46X+10wAAAABJRU5ErkJggg=="

icon_pressed_el_file = "plugin_icon_el_pressed.png"
icon_pressed_el_file_content = "iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAYAAADDPmHLAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH3gUUDy4HbURD9QAAAn1JREFUeNrt3etNXDEUReG5R+4gNBAk6L8eIpEGSA03/1GkzPsee3+rALC919k2CDTbvu8n5FKOgAAIZtz6BX79/tNuU++vLw+51z4+v7Zue337+eNYAVYN+9zv1VGK5QV4ZuiXrGVGGYbQs2UYQs+WYQj+efvpKMIQfLYIQ/DZIpTws/c+BJ/dBiX87DYYgs9ugxJ+dhuU8LMlGILPvhJK+NltUMLPlqCEny1BCT9bghJ+tgQl/GwJ/FVwONut/xiybZvpP5B937fDGkD4DSb4xgxK+NkSeAOEU6Y/uwVK+NkSuAJcAaY/uQVK+NkSuAJcAaY/uQU0gAYw/cktoAE0gOlPbgENoAFAAPUfew1oAA0AAqj/2GtAA2gAEED9x14DGkADgAAgAAjgARj4ENQAGgAEAAFAABAABAABQAAQAAQAAUAAEAAEAAFAABAABAABQACsJsCtnz6B/nzPWANoABAABAABPATDHoAaAAQgwJlVgfXqXwOAAAS4sDKwTv1rABCAAFdWB+avfw2A/wugBdadfg2A8wTQAmtOvwbA+QJogfWm/+IGIMFa4bsCcLkAWmCd6b+6AUiwRviuAFwvgBaYf/pvbgASzB3+Xa6Aj88vEhzEPc7eG8AboIeJOObMq9uC8Nyzrq4Lw3POuLovEI8925plocJ/zJnWbAsW/n0Zz1j4++uLTyRtOkS1ykaE31gAEvQ9q3HExlwJfYakUjYq/AYNoA36DUOlH0D63keng0hpg07Sj44Hs6oIHdtudD6oVUTofM2NWQ5uNhlmeduMGQ+0qwwzPmjHaUI6yTD7TzHjNDn/CuBRUqz4I+u2734rm4y/CiYAkvkLwp9KeKsKcUQAAAAASUVORK5CYII="

icon_pressed_file = "plugin_icon_pressed.png"
icon_pressed_file_content = icon_pressed_el_file_content

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
        setIcon(R.drawable.plugin_icon_normal);
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
create_binary_file(os.path.join(drawable_directory, icon_normal_file), icon_normal_file_content.decode('base64'))
create_binary_file(os.path.join(drawable_directory, icon_normal_el_file), icon_normal_el_file_content.decode('base64'))
create_binary_file(os.path.join(drawable_directory, icon_pressed_file), icon_pressed_file_content.decode('base64'))
create_binary_file(os.path.join(drawable_directory, icon_pressed_el_file), icon_pressed_el_file_content.decode('base64'))
copy_file(os.path.join('..', 'bin', 'atoomasdk.jar'), os.path.join(libs_directory, 'atoomasdk.jar'))

