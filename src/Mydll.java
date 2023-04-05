import com.sun.jna.Library;
import com.sun.jna.Native;

public interface Mydll extends Library {
    public void RealTimeSpeechTranslate();
    Mydll a = (Mydll) Native.loadLibrary("Rt-st", Mydll.class);
}
