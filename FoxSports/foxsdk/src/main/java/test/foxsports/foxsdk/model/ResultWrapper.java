package test.foxsports.foxsdk.model;

import java.util.List;

public class ResultWrapper<T extends Model> {

    public final T resultObject;
    public int resultCode;
    public List<T> resultArray;
    public String sError;

    public ResultWrapper(List<T> resultList, T resultObject, int resultCode, String sError) {
        this.resultArray = resultList;
        this.resultObject = resultObject;
        this.resultCode = resultCode;
        this.sError = sError;
    }
}
