package serverwofacade;

public class MyFacade {
    private static MyFacade myFacadeObj = null;
        private MyFacade() {}
    ScheduleServer scheduleServer = new ScheduleServer();

    public static MyFacade getMyFacade(){
        if (myFacadeObj == null) {
            myFacadeObj = new MyFacade();
        }
        return myFacadeObj;
    }
    public void startServer(){
        scheduleServer.startBooting();
        scheduleServer.readSystemConfigFile();
        scheduleServer.init();
        scheduleServer.initializeContext();
        scheduleServer.initializeListeners();
        scheduleServer.createSystemObjects();
    }
    public void stopServer(){
        scheduleServer.releaseProcesses();
        scheduleServer.destory();
        scheduleServer.destroySystemObjects();
        scheduleServer.destoryListeners();
        scheduleServer.destoryContext();
        scheduleServer.shutdown();
    }
}
