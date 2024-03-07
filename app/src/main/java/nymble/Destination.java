package app.src.main.java.nymble;

import java.util.ArrayList;
import java.util.List;

public class Destination {
    
    private String name;
    private List<Activity> activities;

    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public Activity geActivity (Activity activity){
        for(Activity currActivity :activities){
            if(currActivity.getName()==activity.getName()&&currActivity.getDestination()==activity.getDestination()){
                return currActivity;
            }
        }
        return null;
    }

}
