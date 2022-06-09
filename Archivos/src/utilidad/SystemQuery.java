package utilidad;

/**
 * Esta clase se encarga de consultar al sistema tanto que SO utiliza, arquitectura y version de la misma
 */
public class SystemQuery{

    private static String OS = System.getProperty("os.name").toLowerCase();
    private static String OSArch = System.getProperty("os.arch").toLowerCase();
    private static String OSVersion = System.getProperty("os.version").toLowerCase();

    public static boolean isWindows(){
        return (OS.indexOf("win") >= 0);
    }

    public static boolean isUnix(){
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
    }

    public static boolean isMacOS(){
        return (OS.indexOf("mac") >= 0);
    }

    public static boolean isSolaris(){
        return (OS.indexOf("solus") >= 0);
    }

    public static String getOSArch(){
        return OSArch;
    }

    public static String getOSVersion(){
        return OSVersion;
    }
    
}