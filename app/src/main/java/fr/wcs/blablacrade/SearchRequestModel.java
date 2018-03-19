package fr.wcs.blablacrade;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bastienwcs on 21/09/17.
 */

public class SearchRequestModel implements Parcelable {

    public static final Creator<SearchRequestModel> CREATOR = new Creator<SearchRequestModel>() {
        @Override
        public SearchRequestModel createFromParcel(Parcel in) {
            return new SearchRequestModel(in);
        }

        @Override
        public SearchRequestModel[] newArray(int size) {
            return new SearchRequestModel[size];
        }
    };
    private String depart;
    private String destination;
    private String date;

    public SearchRequestModel(String depare, String destination, String date) {
        this.depart = depare;
        this.destination = destination;
        this.date = date;
    }

    protected SearchRequestModel(Parcel in) {
        depart = in.readString();
        destination = in.readString();
        date = in.readString();
    }

    public String getDepart() {
        return depart;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(depart);
        dest.writeString(destination);
        dest.writeString(date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getDate() {
        return date;
    }
}
