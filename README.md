kollavarsham-java
=================

## Information
The JAVA API port for Kollavarsham (http://kollavarsham.org)

## Getting Started
Download the sources and build using ant in the project root directory.
```
ant clean compile jar
```
Note: To compile the jUnit tests, download junit.4.xx.jar to {project-root}/lib

To run the diagnostics, use the main() program in Kollavarsham using
```
ant run
```
To run the junit tests, download hamcrest-core-X.X.jar to {project-root}/lib and run the following target
```
ant junit
```
To view the report, run the following target:
``` 
ant junitreport
```
And point your browser to {project-root}/build/junitreport/index.html
To use Kollavarsham API in a different project, add Kollavarsham.jar from {project-root}/build/jar to the classpath

## Usage

```
import org.kollavarsham.Kollavarsham;
...
...
...
	Kollavarsham malayalamYear = new Kollavarsham();
	Calendar modernDate = Calendar.getInstance();
	modernDate.set(2011, Calendar.APRIL, 4);
	malayalamYear.setModernDate(modernDate);
	malayalamYear.setOptions(true, "Ujjain");
	malayalamYear.FromGregorian();
	malayalamYear.getMalayalamYear();
	malayalamYear.getMalayalamMonthNum();
	malayalamYear.getMalayalamNakshatram();
```

## Documentation
TODO

## Contributing
In lieu of a formal styleguide, take care to maintain the existing coding style. Add unit tests for any new or changed functionality.

## Release History
_(Nothing yet)_

## License
Copyright (c) 2014-2017 The Kollavarsham Team. Licensed under the MIT license.
