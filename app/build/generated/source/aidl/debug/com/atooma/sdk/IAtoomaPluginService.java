/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /opt/monossido/ATOOMA/AppGithub/atooma-android-sdk1/app/src/main/aidl/com/atooma/sdk/IAtoomaPluginService.aidl
 */
package com.atooma.sdk;
public interface IAtoomaPluginService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.atooma.sdk.IAtoomaPluginService
{
private static final java.lang.String DESCRIPTOR = "com.atooma.sdk.IAtoomaPluginService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.atooma.sdk.IAtoomaPluginService interface,
 * generating a proxy if needed.
 */
public static com.atooma.sdk.IAtoomaPluginService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.atooma.sdk.IAtoomaPluginService))) {
return ((com.atooma.sdk.IAtoomaPluginService)iin);
}
return new com.atooma.sdk.IAtoomaPluginService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_registerModule:
{
data.enforceInterface(DESCRIPTOR);
com.atooma.sdk.plugin.IModulePlugin _arg0;
_arg0 = com.atooma.sdk.plugin.IModulePlugin.Stub.asInterface(data.readStrongBinder());
this.registerModule(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_trigger:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
com.atooma.sdk.plugin.ParameterBundle _arg3;
if ((0!=data.readInt())) {
_arg3 = com.atooma.sdk.plugin.ParameterBundle.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
this.trigger(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.atooma.sdk.IAtoomaPluginService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void registerModule(com.atooma.sdk.plugin.IModulePlugin module) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((module!=null))?(module.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_registerModule, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void trigger(java.lang.String moduleId, java.lang.String tirggerid, java.lang.String ruleId, com.atooma.sdk.plugin.ParameterBundle variables) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(moduleId);
_data.writeString(tirggerid);
_data.writeString(ruleId);
if ((variables!=null)) {
_data.writeInt(1);
variables.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_trigger, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_registerModule = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_trigger = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
public void registerModule(com.atooma.sdk.plugin.IModulePlugin module) throws android.os.RemoteException;
public void trigger(java.lang.String moduleId, java.lang.String tirggerid, java.lang.String ruleId, com.atooma.sdk.plugin.ParameterBundle variables) throws android.os.RemoteException;
}
