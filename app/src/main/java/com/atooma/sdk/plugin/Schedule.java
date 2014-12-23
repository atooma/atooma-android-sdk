package com.atooma.sdk.plugin;

import android.os.Parcel;
import android.os.Parcelable;

public class Schedule implements Parcelable {

	private boolean repeat;
	private boolean exact;
	private boolean wakeup;
	private long triggerAtTime;
	private long interval;

	public static class Builder {

		private boolean repeat;
		private boolean exact;
		private boolean wakeup;
		private long triggerAtTime;
		private long interval;
		
		public Builder repeat(boolean repeat) {
			this.repeat = repeat;
			return this;
		}
		
		public Builder exact(boolean exact) {
			this.exact = exact;
			return this;
		}
		
		public Builder wakeup(boolean wakeup) {
			this.wakeup = wakeup;
			return this;
		}
		
		public Builder triggerAtTime(long triggerAtTime) {
			this.triggerAtTime = triggerAtTime;
			return this;
		}
		
		public Builder interval(long interval) {
			this.interval = interval;
			return this;
		}

		public Schedule build() {
			return new Schedule(this);
		}
	}

	private Schedule(Builder builder) {
		setRepeat(builder.repeat);
		setExact(builder.exact);
		setWakeUp(builder.wakeup);
		setTriggerAtTime(builder.triggerAtTime);
		setInterval(builder.interval);
	}

	public static final Parcelable.Creator<Schedule> CREATOR = new Parcelable.Creator<Schedule>() {
		public Schedule createFromParcel(Parcel in) {
			return new Schedule(in);
		}

		public Schedule[] newArray(int size) {
			return new Schedule[size];
		}
	};

	public Schedule(Boolean repeat, Boolean exact, Boolean wakeup, Long triggerAtTime, Long interval) {
		this.repeat = repeat;
		this.exact = exact;
		this.wakeup = wakeup;
		this.triggerAtTime = triggerAtTime;
		this.interval = interval;
	}

	private Schedule(Parcel in) {
		readFromParcel(in);
	}

	public void writeToParcel(Parcel out, int arg) {
		out.writeByte((byte) (repeat ? 1 : 0));
		out.writeByte((byte) (exact ? 1 : 0));
		out.writeByte((byte) (wakeup ? 1 : 0));
		out.writeLong(triggerAtTime);
		out.writeLong(interval);
	}

	public void readFromParcel(Parcel in) {
		repeat = in.readByte() != 0;
		exact = in.readByte() != 0;
		wakeup = in.readByte() != 0;
		triggerAtTime = in.readLong();
		interval = in.readLong();
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isRepeat() {
		return repeat;
	}

	public boolean isExact() {
		return exact;
	}

	public boolean isWakeup() {
		return wakeup;
	}

	public long getTriggerAtTime() {
		return triggerAtTime;
	}

	public long getInterval() {
		return interval;
	}
	
	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}
	
	public void setExact(boolean exact) {
		this.exact = exact;
	}
	
	public void setWakeUp(boolean wakeup) {
		this.wakeup = wakeup;
	}
	
	public void setTriggerAtTime(long triggerAtTime) {
		this.triggerAtTime = triggerAtTime;
	}
	
	public void setInterval(long interval) {
		this.interval = interval;
	}

}
