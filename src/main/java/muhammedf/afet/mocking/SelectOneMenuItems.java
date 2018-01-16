package muhammedf.afet.mocking;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Named
@ApplicationScoped
public class SelectOneMenuItems {

    private final List<String> afetTypes = Arrays.asList("yangın", "deprem", "sel", "fırtına");

    public List<String> getAfetTypes() {
        return afetTypes;
    }

    public List<String> iller(){
        return IntStream.range(1,10).boxed().map(i->"il"+i).collect(Collectors.toList());
    }

    public List<String> ilceler(String il){
        if(il==null || il.isEmpty()){
            return Collections.emptyList();
        }
        return IntStream.range(1,10).boxed().map(i->il+"ilçe"+i).collect(Collectors.toList());
    }

    public List<String> koyler(String ilce){
        if(ilce==null || ilce.isEmpty()){
            return Collections.emptyList();
        }
        return IntStream.range(1,10).boxed().map(i->ilce+"köy"+i).collect(Collectors.toList());
    }

    public List<String> mahalleler(String koy){
        if(koy==null || koy.isEmpty()){
            return Collections.emptyList();
        }
        return IntStream.range(1,10).boxed().map(i->koy+"mahalle"+i).collect(Collectors.toList());
    }

}
