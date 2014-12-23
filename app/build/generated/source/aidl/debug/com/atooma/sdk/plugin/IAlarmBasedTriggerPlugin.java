/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /opt/monossido/ATOOMA/AppGithub/atooma-android-sdk1/app/src/main/aidl/com/atooma/sdk/plugin/IAlarmBasedTriggerPlugin.aidl
 */
package com.atooma.sdk.plugin;
public interface IAlarmBasedTriggerPlugin extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.atooma.sdk.plugin.IAlarmBasedTriggerPlugin
{
private static final java.lang.String DESCRIPTOR = "com.atooma.sdk.plugin.IAlarmBasedTriggerPlugin";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.atooma.sdk.plugin.IAlarmBasedTriggerPlugin interface,
 * generating a proxy if needed.
 */
public static com.atooma.sdk.plugin.IAlarmBasedTriggerPlugin asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.atooma.sdk.plugin.IAlarmBasedTriggerPlugin))) {
return ((com.atooma.sdk.plugin.IAlarmBasedTriggerPlugin)iin);
}
return new com.atooma.sdk.plugin.IAlarmBasedTriggerPlugin.Stub.Proxy(obj);
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
case TRANSACTION_isVisible:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isVisible();
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
case TRANSACTION_getParameters:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<com.atooma.sdk.plugin.Values> _result = this.getParameters();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getVariables:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<com.atooma.sdk.plugin.Values> _result = this.getVariables();
reply.writeNoException();
reply.writeTypedList(_result);
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
case TRANSACTION_getParameterLabelIfNullResources:
{
data.enforceInterface(DESCRIPTOR);
java.util.List _result = this.getParameterLabelIfNullResources();
reply.writeNoException();
reply.writeList(_result);
return true;
}
case TRANSACTION_getParameterTitleResources:
{
data.enforceInterface(DESCRIPTOR);
java.util.List _result = this.getParameterTitleResources();
reply.writeNoException();
reply.writeList(_result);
return true;
}
case TRANSACTION_getVariableTitleResources:
{
data.enforceInterface(DESCRIPTOR);
java.util.List _result = this.getVariableTitleResources();
reply.writeNoException();
reply.writeList(_result);
return true;
}
case TRANSACTION_timeout:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
com.atooma.sdk.plugin.ParameterBundle _arg1;
if ((0!=data.readInt())) {
_arg1 = com.atooma.sdk.plugin.ParameterBundle.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
this.timeout(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_revoke:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.revoke(_arg0);
reply.writeNoException();
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
case TRANSACTION_getScheduleInfo:
{
data.enforceInterface(DESCRIPTOR);
com.atooma.sdk.plugin.Schedule _result = this.getScheduleInfo();
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.atooma.sdk.plugin.IAlarmBasedTriggerPlugin
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
@Override public java.util.List<com.atooma.sdk.plugin.Values> getParameters() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.atooma.sdk.plugin.Values> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getParameters, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.atooma.sdk.plugin.Values.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.util.List<com.atooma.sdk.plugin.Values> getVariables() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<com.atooma.sdk.plugin.Values> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getVariables, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(com.atooma.sdk.plugin.Values.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
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
@Override public java.util.List getParameterLabelIfNullResources() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getParameterLabelIfNullResources, _data, _reply, 0);
_reply.readException();
java.lang.ClassLoader cl = (java.lang.ClassLoader)this.getClass().getClassLoader();
_result = _reply.readArrayList(cl);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.util.List getParameterTitleResources() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getParameterTitleResources, _data, _reply, 0);
_reply.readException();
java.lang.ClassLoader cl = (java.lang.ClassLoader)this.getClass().getClassLoader();
_result = _reply.readArrayList(cl);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.util.List getVariableTitleResources() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getVariableTitleResources, _data, _reply, 0);
_reply.readException();
java.lang.ClassLoader cl = (java.lang.ClassLoader)this.getClass().getClassLoader();
_result = _reply.readArrayList(cl);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void timeout(java.lang.String ruleId, com.atooma.sdk.plugin.ParameterBundle parameters) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(ruleId);
if ((parameters!=null)) {
_data.writeInt(1);
parameters.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_timeout, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void revoke(java.lang.String ruleId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(ruleId);
mRemote.transact(Stub.TRANSACTION_revoke, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
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
@Override public com.atooma.sdk.plugin.Schedule getScheduleInfo() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.atooma.sdk.plugin.Schedule _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getScheduleInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.atooma.sdk.plugin.Schedule.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_isVisible = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getParameters = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getVariables = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_getTitleResource = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_getIconResourceNormal = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_getParameterLabelIfNullResources = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_getParameterTitleResources = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_getVariableTitleResources = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_timeout = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_revoke = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_getVersion = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_getScheduleInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
}
public boolean isVisible() throws android.os.RemoteException;
public java.lang.String getId() throws android.os.RemoteException;
public java.util.List<com.atooma.sdk.plugin.Values> getParameters() throws android.os.RemoteException;
public java.util.List<com.atooma.sdk.plugin.Values> getVariables() throws android.os.RemoteException;
public int getTitleResource() throws android.os.RemoteException;
public int getIconResourceNormal() throws android.os.RemoteException;
public java.util.List getParameterLabelIfNullResources() throws android.os.RemoteException;
public java.util.List getParameterTitleResources() throws android.os.RemoteException;
public java.util.List getVariableTitleResources() throws android.os.RemoteException;
public void timeout(java.lang.String ruleId, com.atooma.sdk.plugin.ParameterBundle parameters) throws android.os.RemoteException;
public void revoke(java.lang.String ruleId) throws android.os.RemoteException;
public int getVersion() throws android.os.RemoteException;
public com.atooma.sdk.plugin.Schedule getScheduleInfo() throws android.os.RemoteException;
}
