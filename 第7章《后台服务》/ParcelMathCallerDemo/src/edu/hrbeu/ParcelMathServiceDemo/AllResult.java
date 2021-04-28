package edu.hrbeu.ParcelMathServiceDemo;

import android.os.Parcel;
import android.os.Parcelable;

public class AllResult implements Parcelable {

	public long AddResult;
	public long SubResult;
	public long MulResult;
	public double DivResult;
	
	public AllResult(long addRusult, long subResult, long mulResult, double divResult){
		AddResult = addRusult;
		SubResult = subResult;
		MulResult = mulResult;
		DivResult = divResult;
	}

	
	public AllResult(Parcel parcel) {
		AddResult  = parcel.readLong();
		SubResult  = parcel.readLong();
		MulResult  = parcel.readLong();
		DivResult  = parcel.readDouble();
	}
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(AddResult);
		dest.writeLong(SubResult);	
		dest.writeLong(MulResult);	
		dest.writeDouble(DivResult);	
	}

	public static final Parcelable.Creator<AllResult> CREATOR =
		new Parcelable.Creator<AllResult>(){
		public AllResult createFromParcel(Parcel parcel){
			return new AllResult(parcel);
		}
		public AllResult[] newArray(int size){
			return new AllResult[size];
		}
	};
}
