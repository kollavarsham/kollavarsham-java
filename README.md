kollavarsham-java
=================

## Information
The JAVA API port for Kollavarsham (http://kollavarsham.org)

## Getting Started
To use this source, clone this repository to local and create an Eclipse Java project from the cloned directory.
jars for download and ant build scripts will be added soon.

## Usage

```
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