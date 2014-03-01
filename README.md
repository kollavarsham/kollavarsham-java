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
	malayalamYear.setOptions(true, 23.2, 75.8);
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
Copyright (c) 2014 The Kollavarsham Team. Licensed under the MIT license.