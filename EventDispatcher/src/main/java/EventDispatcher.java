import org.apache.commons.lang3.ClassUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by RENT on 2017-09-15.
 */
public class EventDispatcher {
    private static EventDispatcher ourInstance = new EventDispatcher();
    private ExecutorService theads = Executors.newSingleThreadExecutor();
    private Map<Class<?>, List<?>> map = new HashMap<>();

    public static EventDispatcher getInstance() {
        return ourInstance;
    }

    private EventDispatcher() {

    }

    /**
     * Zarejestruj obiekt do dispatchera.
     *
     * @param o - obiekt do zarejestrowania
     */
    public void registerObject(Object o) {
        // pobieram listę interfejsów które implemetuje klasa
        List<Class<?>> interfacesImplementedByObject = ClassUtils.getAllInterfaces(o.getClass());

        // dla każdego z tych interfejsów dodaję go do listy obiektów je
        // implementujących
        for (Class<?> classtype : interfacesImplementedByObject) {
            System.out.println("Rejestruje obiekt: " + o + " - implementuje interfejs " + classtype.getName());
            List objects = map.get(classtype);
            if (objects == null) { // jeśli lista nie istnieje (nie ma obiektu
                // który implementuje ten interfejs)
                objects = new ArrayList<>(); // tworze nowa liste
            }
            objects.add(o); // dodaje obiekt do listy
            map.put(classtype, objects); // umieszczam listę z powrotem w mapie

        }
    }

    /**
     * Zwraca wszystkie obiekty które implementuja dany interfejs.
     *
     * @param clas - interfejs szukany
     * @return zwraca kolekcję obiektów
     */
    public <T> List<T> getAllObjectsImplementingInterface(Class<T> clas) {
        List<T> lista = (List<T>) map.get(clas);
        System.out.println("Szukam obiektów implementujących interfejs: " + clas.getName() + " znalezione obiekty: ");
        for (T t : lista) {
            System.out.println(" ----> " + t);
        }
        System.out.println();

        return (List<T>) map.get(clas);
    }

    /**
     * Wyrejestrowuje obiekt z dispatchera (przestaje słuchać co lata w eterze).
     *
     * @param o - obiekt do wyrejestrowania
     */
    public void unregisterObject(Object o) {
        List<Class<?>> interfacesImplementedByObject = ClassUtils.getAllInterfaces(o.getClass()); // pobieram interfejsy które obiekt implementuje
        for (Class<?> classtype : interfacesImplementedByObject) { // dla każdego interfejsu
            System.out.println("Wyrejestrowuje obiekt: " + o + " - implementujący interfejs " + classtype.getName());
            List objects = map.get(classtype);  // pobieram listę obiektów które posiadam, które implementują ten interfejs (z tej listy chcę usunać obiekt o)
            if (objects != null) { // jeśli lista nie istnieje ( to nie ma obiektu który implementuje ten interfejs)
                objects.remove(o); // usuwam z listy
            }
//            map.put(classtype, objects); // umieszczam listę z powrotem w mapie
        }
    }

    /**
     * Asynchronicznie wywołuje na puli wątków zdarzenie.
     *
     * @param e - zdarzenie do uruchomienia (implementuje obiekt iEvent)
     *          tutaj znowu strategia Execute
     */
    public void dispatch(Event e) {
        System.out.println("Dispatch zdarzenia : " + e);
        /**
         * Drugą opcją jest implementowanie przez IEvent interfejsu Runnable. Wybrałem tą opcję.
         * Zastanów się dlaczego?
         */
        theads.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    e.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
