package h;
import core.*;
import core.annotation.*;

// aufqatak555umhtr2zwzdxcam

@TranslatedBy("plantuml") 
public class gvlayout_engine_s extends Structure {
    static public interface layout extends FP {
        StarVoid function(Agraph_s g);
    }
    public layout layout;

    static public interface cleanup extends FP {
        StarVoid function(Agraph_s g);
    }
    public cleanup cleanup;
} 

// struct gvlayout_engine_s {
// 	void (*layout) (graph_t * g);
// 	void (*cleanup) (graph_t * g);
//     };