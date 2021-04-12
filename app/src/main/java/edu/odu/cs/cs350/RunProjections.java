/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.odu.cs.cs350;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;


public class RunProjections {

	private SummaryProjectionReport summaryReport;
	private DetailedProjectionReport detailedReport;

    public RunProjections() {
    	summaryReport = new SummaryProjectionReport();
    	detailedReport = new DetailedProjectionReport();
	}
     
    public static void main(String[] args) throws Throwable {
    	
    	List<Semester> semesterList = new ArrayList<>();
    	
    	//check to see if enough parameters were provided
    	if(args.length < 2)
    	{
    		System.err.println("Not enough parameters passed to program.");
    		System.exit(1);
    	}  
    	
    	//for every input argument provided, add a new semester 
    	for (int i = 0; i < args.length - 1; i++)
    	{
    		semesterList.add(new Semester());
			try {
				semesterList.get(i).setPath(args[i]);
			} catch (MalformedURLException e) {
				//Does not throw error when invalid URL is passed yet
    		  	System.err.println("Invalid URL passed: " + args[i]);
    		}
    	}

		RunProjections prog = new RunProjections();

		try {
			prog.detailedReport.outputviaCLI(args[args.length-1]);
		} catch (IOException e) {
			//Do something
		}
		
		/*
		for (int i = 0; i < semesterList.size(); i++)
		{
			//check to see that only lectures are added
			
			if (!(semesterList.get(i).EnrollmentSnapshots.get(i).getCOLL().split(".") == "LAB") 
				&& (semesterList.get(i).EnrollmentSnapshots.get(i).getCOLL()split(".") == "RECITATION"))
			prog.summaryReport.addCourse(new CourseProjection(semesterList.get(i).getName(), semesterList.get(i).EnrollmentSnapshots.get(i).getOVERALL_CAP()));
		}
		*/
		
    	//Automate this later when the projections are actually being calculated.	
		prog.summaryReport.addCourse(new CourseProjection("CS120G", 100));
		prog.summaryReport.addCourse(new CourseProjection("CS170G", 75));
		prog.summaryReport.addCourse(new CourseProjection("CS150", 130));
    	prog.summaryReport.displayProjectionResults("2021-01-01", "2021-01-31", "2021-01-22");
        
    }
}
