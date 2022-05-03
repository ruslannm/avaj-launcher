package Tower;

import flyable.Baloon;
import flyable.Flyable;
import flyable.Helicopter;
import flyable.JetPlane;

import java.util.ArrayList;
import java.util.List;

import static simulator.Simulator.writeLog;

public class Tower {
    private List<Flyable> observer = new ArrayList();

    public void register(Flyable flyable) {
        observer.add(flyable);
        writeRegLog(flyable, "registered to");
    }

    public void unregister(Flyable flyable) {
        if (observer.contains(flyable)) {
            writeRegLog(flyable, "unregistered from");
            observer.remove(flyable);
        }
    }

    private void writeRegLog(Flyable flyable, String action) {
        if (flyable instanceof JetPlane) {
            writeLog("Tower says: JetPlane#" + ((JetPlane) flyable).getName() + "(" + ((JetPlane) flyable).getId() + ") " + action + " weather tower.");
        }   else if (flyable instanceof Helicopter) {
            writeLog("Tower says: Helicopter#" + ((Helicopter) flyable).getName() + "(" + ((Helicopter) flyable).getId() + ") " + action + " weather tower.");
        } else if (flyable instanceof Baloon) {
            writeLog("Tower says: Baloon#" + ((Baloon) flyable).getName() + "(" + ((Baloon) flyable).getId() + ") " + action + " weather tower.");
        }
    }

    protected void conditionChanged() {
        if (!observer.isEmpty()){
            for (int i = 0; i < observer.size(); i++){
                observer.get(i).updateConditions();
            }
        }
    }
}
