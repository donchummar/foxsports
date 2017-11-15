package test.foxsports.foxsdk.model;

import java.util.List;

public class ResultWrapper<T extends Model> {
    public int resultCode;
    public List<T> resultArray;
    public String sError;

    public ResultWrapper(List<T> list, int resultCode, String sError) {
        this.resultArray = list;
        this.resultCode = resultCode;
        this.sError = sError;
    }
}
