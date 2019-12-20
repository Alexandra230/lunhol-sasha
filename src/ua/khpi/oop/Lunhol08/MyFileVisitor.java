package ua.khpi.oop.Lunhol08;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class MyFileVisitor extends SimpleFileVisitor<Path> {
@Override
public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
System.out.println(file.getFileName());
return FileVisitResult.CONTINUE;
}
}