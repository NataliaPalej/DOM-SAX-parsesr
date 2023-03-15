package project2023;

/**
 * @author jackiestewart
 */
public class Golf {
    private String name, year, strokePlay, winner, winningScore, courseLocation,course, 
            favourite, youngestCompetitor;

    // default constructor
    public Golf() {
    }

    // constructor overloaded
    public Golf(String name, String year, String strokePlay, String winner, String winningScore, String courseLocation, String course, String favourite, String youngestCompetitor) {
        this.name = name;
        this.year = year;
        this.strokePlay = strokePlay;
        this.winner = winner;
        this.winningScore = winningScore;
        this.courseLocation = courseLocation;
        this.course = course;
        this.favourite = favourite;
        this.youngestCompetitor = youngestCompetitor;
    }
    
     //create getter and setter methods for each variables
    public String getName() {
        return name;
    }
      public void setName(String name) {
        this.name = name;
     }

    public String getYear() {
        return year;
    }
     public void setYear(String year) {
        this.year = year;
    }
     
    public String getStrokePlay() {
        return strokePlay;
    }
    public void setStrokePlay(String strokePlay) {
        this.strokePlay = strokePlay;
    }
    
    public String getWinner() {
        return winner;
    }
    public void setWinner(String winner) {
        this.winner = winner;
    }
    
    public String getWinningScore() {
        return winningScore;
    }
    public void setWinningScore(String winningScore) {
        this.winningScore = winningScore;
    }
    
    public String getCourseLocation() {
        return courseLocation;
    }
     public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
    }
    
    public String getCourse() {
        return course;
    }
      public void setCourse(String course) {
        this.course = course;
    }
         
    public String getFavourite() {
        return favourite;
    }
     public void setFavourite(String favourite) {
        this.favourite = favourite;
    }
    
    public String getYoungestCompetitor() {
        return youngestCompetitor;
    }
     public void setYoungestCompetitor(String youngestCompetitor) {
        this.youngestCompetitor = youngestCompetitor;
    }   
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("\n  2022 Golf Tournament Details: - "); //added line break
        sb.append("\n");
          sb.append("Name : "+ name);
        sb.append(",\n");
         sb.append("Year : "+ year);
        sb.append(",\n");
         sb.append("StrokePlay : "+ strokePlay);
        sb.append(",\n");
        sb.append("Winner : "+ winner);
        sb.append(",\n");  
         sb.append("WinningScore : "+ winningScore);
        sb.append(",\n");
         sb.append("CourseLoacation : "+ courseLocation);
        sb.append(",\n");
         sb.append("Course: "+ course);
        sb.append(",\n");
         sb.append("Favourite : "+ favourite);
        sb.append(",\n");
        sb.append("YoungestCompetitor : "+ youngestCompetitor);
        sb.append(",\n");
       
        return sb.toString();
    }//end of toString method    
}//end of public class Golf
