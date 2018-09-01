package squareandcube.com.displaycontacts;

import android.content.Context;
import android.graphics.Bitmap;

public class Contact  {
    Context context;
    private String name;
    private String number;
    private Bitmap contactImage;

    public String getContactImage1() {
        return contactImage1;
    }

    public void setContactImage1(String contactImage1) {
        this.contactImage1 = contactImage1;
    }

    private String contactImage1;
    public void setContactImage(Bitmap contactImage) {
        this.contactImage = contactImage;
    }

    public Bitmap getContactImage() {

        return contactImage;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
