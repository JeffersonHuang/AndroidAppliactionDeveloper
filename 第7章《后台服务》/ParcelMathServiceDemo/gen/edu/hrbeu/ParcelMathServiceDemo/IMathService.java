/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: G:\\Android\\workplace\\ParcelMathServiceDemo\\src\\edu\\hrbeu\\ParcelMathServiceDemo\\IMathService.aidl
 */
package edu.hrbeu.ParcelMathServiceDemo;
public interface IMathService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements edu.hrbeu.ParcelMathServiceDemo.IMathService
{
private static final java.lang.String DESCRIPTOR = "edu.hrbeu.ParcelMathServiceDemo.IMathService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an edu.hrbeu.ParcelMathServiceDemo.IMathService interface,
 * generating a proxy if needed.
 */
public static edu.hrbeu.ParcelMathServiceDemo.IMathService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof edu.hrbeu.ParcelMathServiceDemo.IMathService))) {
return ((edu.hrbeu.ParcelMathServiceDemo.IMathService)iin);
}
return new edu.hrbeu.ParcelMathServiceDemo.IMathService.Stub.Proxy(obj);
}
public android.os.IBinder asBinder()
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
case TRANSACTION_Add:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
long _arg1;
_arg1 = data.readLong();
long _result = this.Add(_arg0, _arg1);
reply.writeNoException();
reply.writeLong(_result);
return true;
}
case TRANSACTION_ComputeAll:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
long _arg1;
_arg1 = data.readLong();
edu.hrbeu.ParcelMathServiceDemo.AllResult _result = this.ComputeAll(_arg0, _arg1);
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
private static class Proxy implements edu.hrbeu.ParcelMathServiceDemo.IMathService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
public long Add(long a, long b) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
long _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(a);
_data.writeLong(b);
mRemote.transact(Stub.TRANSACTION_Add, _data, _reply, 0);
_reply.readException();
_result = _reply.readLong();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
public edu.hrbeu.ParcelMathServiceDemo.AllResult ComputeAll(long a, long b) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.hrbeu.ParcelMathServiceDemo.AllResult _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(a);
_data.writeLong(b);
mRemote.transact(Stub.TRANSACTION_ComputeAll, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = edu.hrbeu.ParcelMathServiceDemo.AllResult.CREATOR.createFromParcel(_reply);
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
static final int TRANSACTION_Add = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_ComputeAll = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
public long Add(long a, long b) throws android.os.RemoteException;
public edu.hrbeu.ParcelMathServiceDemo.AllResult ComputeAll(long a, long b) throws android.os.RemoteException;
}
