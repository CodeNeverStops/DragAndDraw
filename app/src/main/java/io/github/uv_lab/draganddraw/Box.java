package io.github.uv_lab.draganddraw;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by youwei on 2016/11/18.
 */

public class Box implements Parcelable {
    private PointF mOrigin;
    private PointF mCurrent;

    public static final Parcelable.Creator<Box> CREATOR = new Creator<Box>() {
        @Override
        public Box createFromParcel(Parcel source) {
            PointF origin = new PointF();
            PointF current = new PointF();
            origin.readFromParcel(source);
            current.readFromParcel(source);
            Box b = new Box(origin);
            b.setCurrent(current);
            return b;
        }

        @Override
        public Box[] newArray(int size) {
            return new Box[size];
        }
    };

    public Box(PointF origin) {
        mOrigin = origin;
        mCurrent = origin;
    }

    public PointF getCurrent() {
        return mCurrent;
    }

    public void setCurrent(PointF current) {
        mCurrent = current;
    }

    public PointF getOrigin() {
        return mOrigin;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        mOrigin.writeToParcel(dest, flags);
        mCurrent.writeToParcel(dest, flags);
    }

}
