package program.mycomparator3;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.Comparator;

public class Person extends ListActivity implements View.OnClickListener {

    private  String Name;
    private  String Age;

    Button names;
    Button ages;
    Button not;


    String[] myArr = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август",
            "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    String[] myArr2 = {"4", "2", "5", "7", "2", "9", "8", "1"};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        names = (Button) findViewById(R.id.Names);
        ages = (Button) findViewById(R.id.Ages);
        not = (Button) findViewById(R.id.All);


    }

    public String toString(){
        return "Person(age = " + this.Age+" , name="+
                this.Name+")";
    }
    public String getName(){
        return Name;
    }
    public String getAge(){
        return Age;
    }


    @Override
    public void onClick(View v)
    {
        switch (v.getId()){
            case R.id.Names:
                ArrayAdapter<String> Names = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, myArr);
                Comparator<Person> NAME_COMPARATOR = new Comparator<Person>(){
                    public int compare(Person o3, Person o4){
                        String name1 = o3.getName();
                        String name2 = o4.getName();

                        return name1.compareTo(name2);

                    }
                };
                setListAdapter(Names);
                break;
            case R.id.Ages:
                ArrayAdapter<String> Ages = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, myArr2);
                Comparator<Person> AGE_COMPARATOR = new Comparator<Person>(){
                    public int compare(Person o1, Person o2){
                        String age1 = o1.getAge();
                        String age2 = o2.getAge();

                        return age1.compareTo(age2);
                    }
                };
                break;
            case R.id.All:
                ArrayAdapter<String> Namess = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, myArr);
                ArrayAdapter<String> Agess = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, myArr2);
                setListAdapter(Namess);
                setListAdapter(Agess);
                break;
        }

    }
}
