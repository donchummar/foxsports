package test.foxsports.foxsdk.utils;

public interface ImageReceiver {

    void imageReceived(int identifier);

    void onError(int identifier, int errorCode);
}