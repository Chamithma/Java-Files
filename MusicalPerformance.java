import java.util.ArrayList;

public class MusicalPerformance { //this is the main class
    public static void main(String[] args) {

        ArrayList <MusicTrack> musicTracks=new ArrayList<>(); //insert tracks for the track array
        musicTracks.add(new MusicTrack("Lavener Haze",11));
        musicTracks.add(new MusicTrack("All Too Well ",7));
        musicTracks.add(new MusicTrack("the lakes",10));
        musicTracks.add(new MusicTrack("The Man",8));
        musicTracks.add(new MusicTrack("Love story ",4));

        ArrayList <backupSinger> backupSingers =new ArrayList<>(); //insert backup singers for the array
        backupSingers.add(new backupSinger("jeslyn"));
        backupSingers.add(new backupSinger("Jake"));

        ArrayList <backupDancer> backupDancers=new ArrayList<>(); //insert backup dancers for the array.
        backupDancers.add(new backupDancer("Stephanie"));
        backupDancers.add(new backupDancer("Melenie"));
        // create Liveperformance object
        LivePerformance LivePerformance = new LivePerformance(new mainArtist("Taylor Swift"),"Glendale","2023","Eras Tour",musicTracks,backupSingers, backupDancers );
    
        LivePerformance.startPerformance();
        LivePerformance.interaction();
    
    }
}
// abstract class musicalPerformance and a super class for LivePerformance and StudioPerformance sub classes
abstract class musicalPerformace {
    private mainArtist mainArtist;
    private String performanceName;
    private final String year;
    private final String venue;
    private ArrayList<MusicTrack> trackList;
    private ArrayList<backupSinger> backupSingers;
    private ArrayList<backupDancer> backupDancers;

    public musicalPerformace(mainArtist mainArtist, String performanceName, String year, String venue,ArrayList<MusicTrack> trackList, ArrayList<backupSinger> backupSingers, ArrayList<backupDancer> backupDancers) {
        this.mainArtist = mainArtist;
        this.performanceName = performanceName;
        this.year = year;
        this.venue = venue;
        this.trackList = trackList;
        this.backupDancers = backupDancers;
        this.backupSingers = backupSingers;
    }
    // getters and setters
    public mainArtist getMainArtist() {
        return mainArtist;
    }
    public void setMainArtist(mainArtist mainArtist) {
        this.mainArtist = mainArtist;
    }

    public String getName() {
        return performanceName;
    }
    public void setName(String performanceName) {
        this.performanceName = performanceName;
    }

    public String getYear() {
        return year;
    }

    public String getVenue() {
        return venue;
    }

    public ArrayList<MusicTrack> getTrackList() {
        return trackList;
    }

    public void setTrackList(ArrayList<MusicTrack> trackList) {
        this.trackList = trackList;
    }

    public ArrayList<backupSinger> getBackUpSingers() {
        return backupSingers;
    }

    public void setBackUpSingers(ArrayList<backupSinger> backupSingers) {
        this.backupSingers = backupSingers;
    }

    public ArrayList<backupDancer> getBackUpDancers() {
        return backupDancers;
    }

    public void setBackUpDancers(ArrayList<backupDancer> backupDancers) {
        this.backupDancers = backupDancers;
    }
    // this is an abstract method
    public abstract void record();

    public void startPerformance(){
        System.out.println("Welcome to the Performance "+performanceName+ " by "+mainArtist.getName()+" !");

        
        this.mainArtist.sing();
        this.backupSingers.forEach(backupSinger::backup);
        this.backupSingers.forEach(backupSinger::sing);
        this.backupDancers.forEach(backupDancer::backup);
        this.backupDancers.forEach(backupDancer::dance);
        this.record();
        
    }
}
// musicalTrack class
class MusicTrack{
    String trackName;
    int duration;

    public MusicTrack(String trackName, int duration){
        this.trackName = trackName;
        this.duration = duration;
    }
    public void setName(String trackName){
        this.trackName = trackName;
    }
    public String getName(){
        return this.trackName;
    }
    public void setDuration(int duration){
        this.duration = duration;
    }
    public int getDuration(){
        return this.duration;
    }

}
// all the artists belongs to this class (super class for mainArtist, bachupSinger, and backupDancer classes)
class Artist{
    String artistName;

    public Artist(String artistName){
        this.artistName = artistName;
        
    }
    public void setName(String artistName){
        this.artistName = artistName;
    }
    public String getName(){
        return this.artistName;
    }
    
}
// interfaces
interface  IBackUp {
    public  void backup();
}
interface ISinger {
    public void sing();

}
interface IDancer {
    public  void dance();
}
// subclass of Artist and extended by ISinger interface
class mainArtist extends Artist implements ISinger{
    
    public mainArtist(String artistName){
        super(artistName);
    }
    public void sing() {
        System.out.println("this is the method sing of the class mainArtist" +getClass().getName() +" ("+artistName+") ");
    }
    
}
// subclass of Artist and extended by ISinger and IBackup interface
class backupSinger extends Artist implements ISinger, IBackUp{

    public backupSinger(String artistName){
        super(artistName);
    }
    public void sing() {
        System.out.println("this is the method sing of the class" +getClass().getName() +" ("+artistName+") ");
    }
    public void backup() {
        System.out.println("This is the method backup of the class"+getClass().getName() +" ("+artistName+") ");
    }
    
}
// subclass of Artist and extended by IDancer and IBackup interface
class backupDancer extends Artist implements IDancer, IBackUp{

    public backupDancer(String artistName){
        super(artistName);
    }
    public void dance() {
        System.out.println("this is the method dance of the class" +getClass().getName() +" ("+artistName+") ");
    }
    public void backup() {
        System.out.println("This is the method backup of the class" +getClass().getName() +" ("+artistName+") ");
    }
    
}
//Subclass of musicalPerformance 
class LivePerformance extends musicalPerformace{

    public LivePerformance (mainArtist mainArtist, String performanceName, String year, String venue, ArrayList<MusicTrack> trackList, ArrayList<backupSinger> backupSingers, ArrayList<backupDancer> backupDancers){
        super( mainArtist, performanceName, year, venue, trackList, backupSingers, backupDancers);
    }

    public void interaction(){
        System.out.println("this is the method interaction in the class  "+getClass().getName());
    }
    public void record(){
        System.out.println("this is the method record in the class " + getClass().getName());
    }
}
//Subclass of musicalPerformance 
class StudioPerformance extends musicalPerformace{

    public StudioPerformance (mainArtist mainArtist, String performanceName, String year, String venue, ArrayList<MusicTrack> trackList, ArrayList<backupSinger> backupSingers, ArrayList<backupDancer> backupDancers){
        super( mainArtist, performanceName, year, venue, trackList, backupSingers, backupDancers);
    }

    public void audioProcessing(){
        System.out.println("this is the method audioProcessing in the class  "+getClass().getName());
    }
    public void record(){
        System.out.println("this is the method record in the class " + getClass().getName());

    }
}