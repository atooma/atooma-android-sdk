/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /opt/monossido/ATOOMA/AppGithub/atooma-android-sdk1/app/src/main/aidl/com/atooma/sdk/plugin/IModulePlugin.aidl
 */
package com.atooma.sdk.plugin;
public interface IModulePlugin extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.atooma.sdk.plugin.IModulePlugin
{
private static final java.lang.String DESCRIPTOR = "com.atooma.sdk.plugin.IModulePlugin";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.atooma.sdk.plugin.IModulePlugin interface,
 * generating a proxy if needed.
 */
public static com.atooma.sdk.plugin.IModulePlugin asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.atooma.sdk.plugin.IModulePlugin))) {
return ((com.atooma.sdk.plugin.IModulePlugin)iin);
}
return new com.atooma.sdk.plugin.IModulePlugin.Stub.Proxy(obj);
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
case TRANSACTION_init:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.init();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getId:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getId();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getVersion:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getVersion();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_isVisible:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isVisible();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_setCategory:
{
data.enforceInterface(DESCRIPTOR);
this.setCategory();
reply.writeNoException();
return true;
}
case TRANSACTION_getTitleResource:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getTitleResource();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getIconResourceNormal:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getIconResourceNormal();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getTriggers:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.os.IBinder> _result = this.getTriggers();
reply.writeNoException();
reply.writeBinderList(_result);
return true;
}
case TRANSACTION_getAlarmTriggers:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.os.IBinder> _result = this.getAlarmTriggers();
reply.writeNoException();
reply.writeBinderList(_result);
return true;
}
case TRANSACTION_getIntentTriggers:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.os.IBinder> _result = this.getIntentTriggers();
reply.writeNoException();
reply.writeBinderList(_result);
return true;
}
case TRANSACTION_getConditionCheckers:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.os.IBinder> _result = this.getConditionCheckers();
reply.writeNoException();
reply.writeBinderList(_result);
return true;
}
case TRANSACTION_getPerformers:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.os.IBinder> _result = this.getPerformers();
reply.writeNoException();
reply.writeBinderList(_result);
return true;
}
case TRANSACTION_getPackage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getPackage();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_isAuthRequired:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isAuthRequired();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_isAuthenticated:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isAuthenticated();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_getAutenticatedText:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getAutenticatedText();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_clearAutenticated:
{
data.enforceInterface(DESCRIPTOR);
this.clearAutenticated();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.atooma.sdk.plugin.IModulePlugin
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
@Override public boolean init() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_init, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String getId() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getId, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int getVersion() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getVersion, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean isVisible() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isVisible, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void setCategory() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_setCategory, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public int getTitleResource() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getTitleResource, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int getIconResourceNormal() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getIconResourceNormal, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.util.List<android.os.IBinder> getTriggers() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.os.IBinder> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getTriggers, _data, _reply, 0);
_reply.readException();
_result = _reply.createBinderArrayList();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.util.List<android.os.IBinder> getAlarmTriggers() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.os.IBinder> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAlarmTriggers, _data, _reply, 0);
_reply.readException();
_result = _reply.createBinderArrayList();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.util.List<android.os.IBinder> getIntentTriggers() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.os.IBinder> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getIntentTriggers, _data, _reply, 0);
_reply.readException();
_result = _reply.createBinderArrayList();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.util.List<android.os.IBinder> getConditionCheckers() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.os.IBinder> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getConditionCheckers, _data, _reply, 0);
_reply.readException();
_result = _reply.createBinderArrayList();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.util.List<android.os.IBinder> getPerformers() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<android.os.IBinder> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPerformers, _data, _reply, 0);
_reply.readException();
_result = _reply.createBinderArrayList();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String getPackage() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPackage, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean isAuthRequired() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isAuthRequired, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean isAuthenticated() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isAuthenticated, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String getAutenticatedText() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getAutenticatedText, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void clearAutenticated() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_clearAutenticated, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_init = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getVersion = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_isVisible = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_setCategory = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_getTitleResource = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_getIconResourceNormal = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_getTriggers = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_getAlarmTriggers = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_getIntentTriggers = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_getConditionCheckers = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_getPerformers = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_getPackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_isAuthRequired = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_isAuthenticated = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_getAutenticatedText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
static final int TRANSACTION_clearAutenticated = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
}
public boolean init() throws android.os.RemoteException;
public java.lang.String getId() throws android.os.RemoteException;
public int getVersion() throws android.os.RemoteException;
public boolean isVisible() throws android.os.RemoteException;
public void setCategory() throws android.os.RemoteException;
public int getTitleResource() throws android.os.RemoteException;
public int getIconResourceNormal() throws android.os.RemoteException;
public java.util.List<android.os.IBinder> getTriggers() throws android.os.RemoteException;
public java.util.List<android.os.IBinder> getAlarmTriggers() throws android.os.RemoteException;
public java.util.List<android.os.IBinder> getIntentTriggers() throws android.os.RemoteException;
public java.util.List<android.os.IBinder> getConditionCheckers() throws android.os.RemoteException;
public java.util.List<android.os.IBinder> getPerformers() throws android.os.RemoteException;
public java.lang.String getPackage() throws android.os.RemoteException;
public boolean isAuthRequired() throws android.os.RemoteException;
public boolean isAuthenticated() throws android.os.RemoteException;
public java.lang.String getAutenticatedText() throws android.os.RemoteException;
public void clearAutenticated() throws android.os.RemoteException;
}
