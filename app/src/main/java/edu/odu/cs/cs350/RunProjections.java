/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.odu.cs.cs350;


import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.util.*;


public class RunProjections {

	private SummaryProjectionReport summaryReport;
	private DetailedProjectionReport detailedReport;
	private List<CourseProjection> projections;

    public RunProjections() {
    	summaryReport = new SummaryProjectionReport();
    	detailedReport = new DetailedProjectionReport();
    	projections = new ArrayList<>();
	}
     
    public static void main(String[] args) throws Throwable {
    	
    	List<Semester> historicSems = new ArrayList<>();
    	Semester currentSem = new Semester();
    	
    	//check to see if enough parameters were provided
    	if(args.length < 3)
    	{
    		System.err.println("Not enough parameters passed to program.");
    		System.exit(1);
    	}  
    	
    	//for every input argument provided, add a new semester 
    	for (int i = 0; i < args.length - 2; i++)
    	{
			historicSems.add(new Semester());
			try {
				historicSems.get(i).setPath(args[i]);
			} catch (MalformedURLException e) {
				//Does not throw error when invalid URL is passed yet
    		  	System.err.println("Invalid URL passed: " + args[i]);
    		}
    	}

    	//Load the current semester
    	currentSem.setPath(args[args.length - 2]);

		RunProjections prog = new RunProjections();

		try {
			prog.detailedReport.outputviaCLI(args[args.length-1]);
		} catch (IOException e) {
			//Do something
		}
		
		/*
		for (int i = 0; i < historicSems.size(); i++)
		{
			//increment through every enrollment snapshot in the at each semester
			for (int j = 0; i < historicSems.EnrollemntSnapshots.size(); j++)
			{
				//check to see that only lectures are added to the summary projection report
				if (!(historicSems.get(i).EnrollmentSnapshots.get(j).getCOLL().split(".") == "LAB")
					&& (historicSems.get(i).EnrollmentSnapshots.get(j).getCOLL().split(".") == "RECITATION"))
					prog.summaryReport.addCourse(new CourseProjection(historicSems.get(i).getName(), historicSems.get(i).EnrollmentSnapshots.get(i).getOVERALL_CAP()));
			}
		}
		
		for (int j = 0; i < currentSem.EnrollemntSnapshots.size(); j++)
		{
			//check to see that only lectures are added to the summary projection report
			if (!(currentSem.get(i).EnrollmentSnapshots.get(j).getCOLL().split(".") == "LAB")
				&& (currentSem.get(i).EnrollmentSnapshots.get(j).getCOLL().split(".") == "RECITATION"))
				prog.summaryReport.addCourse(new CourseProjection(currentSem.get(i).getName(), currentSem.get(i).EnrollmentSnapshots.get(i).getOVERALL_CAP()));
		}	
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
   		LocalDateTime now = LocalDateTime.now();  
		prog.summaryReport.displayProjectionResults(currentSem.getPreRegDate(), currentSem.getAddDeadline(), dtf.format(now));
		*/
		
    	//Automate this later when the projections are actually being calculated.	
		prog.summaryReport.addCourse(new CourseProjection("CS120G", 100));
		prog.summaryReport.addCourse(new CourseProjection("CS170G", 75));
		prog.summaryReport.addCourse(new CourseProjection("CS150", 130));
    	prog.summaryReport.displayProjectionResults(currentSem.getPreRegDate(), currentSem.getAddDeadline(), "2021-01-22");
        
    }
}
