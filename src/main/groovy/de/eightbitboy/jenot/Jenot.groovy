package de.eightbitboy.jenot

println 'Hello world!'

Properties properties = new Properties()
File propertiesFile = new File('jenot.properties')
propertiesFile.withInputStream {
    properties.load(it)
}

println properties
