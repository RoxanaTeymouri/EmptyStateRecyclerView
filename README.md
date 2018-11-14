# EmptyStateRecyclerView
EmptyStateRecyclerView is An extension of RecyclerView that helps show loading, empty and error layout in your android app.


## How to download
### Gradle
add this line to your module build.gradle dependecies block:

    compile 'com.roxa.emptystatehelper:1.0.0'

### Maven

    <dependency>
      <groupId>com.roxa.emptystatehelper</groupId>
      <artifactId>emptystatehelper</artifactId>
      <version>1.0.0</version>
      <type>pom</type>
    </dependency>
		## How use this library
### XML
### Step 1: Add EmptyStateRecyclerView in your XML
```xml
<com.roxa.emptystatehelper.EmptyStateRecyclerView
        android:id="@+id/recyclerview_main"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
</com.roxa.emptystatehelper.EmptyStateRecyclerView>
 ```
### you can Custom EmptyStateRecyclerView by add these attributes

```xml
  
        app:emptyDrawable="@drawable/ic_empty_trash"
        app:emptyImageHeight="20dp"
        app:emptyImageWidth="20dp"
        app:emptyMessage="ROxa"
        app:emptyTextColor="@color/colorAccent"
        app:emptyTextSize="14sp"
        app:errorButtonText="errorButRoxa"
        app:errorButtonTextColor="@color/black"
        app:errorButtonTextSize="15sp"
        app:errorDrawable="@drawable/ic_no_connection"
        app:errorImageHeight="50dp"
        app:errorImageWidth="30dp"
        app:errorMessage="errorRoxa"
        app:errorTextColor="@color/colorAccent"
        app:errorTextSize="20sp"
        app:loadingProgressBarColor="@color/green"
        app:loadingProgressBarRadius="200dp"
        app:loadingProgressBarSpinWidth="10dp"
   
```
 
### Java
### Step 2: extend SliderAdapter
in first step you must create an adapter to manage empty Recycle View By this Library
adapt your data model with slides. example implemented adapter with 3 slides:
```java
public class SimpleRVAdapter extends RecyclerView.Adapter<SimpleRVAdapter.SimpleViewHolder> {

    private String[] dataSource;

    public SimpleRVAdapter(String[] dataArgs) {
        dataSource = dataArgs;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SimpleViewHolder(new TextView(parent.getContext()));
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        holder.textView.setText(dataSource[position]);
    }

    @Override
    public int getItemCount() {
      //  return 0;
          return dataSource.length;
    }

}
```
### Step 3: setAdapter in your Activity for use EmptyState
emptyState handled by this library so don't need to worry about that.you should need too setAdapter.

```java
emptyStateRecyclerView.setAdapter(new SimpleRVAdapter(new String[]{}));
```
### Step 4: ErrorState and LoadingState
if you want to use ErrorState and LoadingState ,you should need to add these methods:

```java
 emptyStateRecyclerView.showError();
 emptyStateRecyclerView.showLoading();
```
## So that is Sample Of You Activity:
```java
import com.roxa.emptystatehelper.EmptyStateRecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EmptyStateRecyclerView emptyStateRecyclerView = findViewById(R.id.recyclerview_main);

          emptyStateRecyclerView.setAdapter(new SimpleRVAdapter(new String[]{}));

          emptyStateRecyclerView.showError();
          emptyStateRecyclerView.showLoading();

    }
}



```

