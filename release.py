#!/usr/bin/env python
import os
import zipfile
import argparse

parser = argparse.ArgumentParser(description="Create AtoomaSDK release bundle.")

#TODO
#parser.add_argument("destination", help="The path to the destination directory.")
#parser.add_argument("sdk_root", help="The path to the `sdk` directory.")

parser.add_argument("version", help="Released SDK version.")
args = parser.parse_args()

version = args.version

zip = zipfile.ZipFile('AtoomaSDK-%s.zip' % version, 'w')
zip.write(os.path.join('bin', 'atoomasdk.jar'), os.path.join('sdk', 'AtoomaSDK-%s.jar' % version))
zip.write(os.path.join('tools', 'create_atooma_plugin.py'))
zip.write('README.md')
zip.close()