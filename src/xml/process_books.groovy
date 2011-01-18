package xml

root = new XmlSlurper().parse('books.xml')
println root.book[1].title