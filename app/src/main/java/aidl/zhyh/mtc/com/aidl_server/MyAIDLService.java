package aidl.zhyh.mtc.com.aidl_server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MyAIDLService extends Service {

    private static final String TAG ="zhuyahui";
    public MyAIDLService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"MyAIDLService onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"MyAIDLService onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"MyAIDLService onDestroy()");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG,"MyAIDLService onUnbind()");
        return super.onUnbind(intent);

    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(TAG,"MyAIDLService onRebind()");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mbinder;
    }

    PayAidlInterface.Stub mbinder = new PayAidlInterface.Stub() {
        @Override
        public int calculation(int anInt, int bnInt) throws RemoteException {
            Log.d(TAG, "calculation: "+anInt+"+"+bnInt);
            return anInt+bnInt;
        }

        @Override
        public person getOne() throws RemoteException {
            person p = new person();
            p.setAge(26);
            p.setName("zhuyahui");
            p.setSex("man");
            return p;
        }
    };
}
