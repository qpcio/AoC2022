package Day7;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    List<Directory> directoriesIn = new ArrayList<>();
    List<File> filesIn = new ArrayList<>();
    long size;
    String name;
    Directory myParent;

    public Directory(String name) {
        this.name = name;
    }

    public long sizeOfthisAndBelowFoldersSmallerThan(int size) {
        long result = 0;
        for (Directory d : directoriesIn){
            result+=d.sizeOfthisAndBelowFoldersSmallerThan(size);
        }
        if(this.size<=size){
            result+=this.size;
        }
        return result;
    }

    public long sizeOfSmallestThatIsAtLeas(long size, long currentSmallest){

        if(this.size<size)return currentSmallest;
        else {
//            System.out.println(this.name+", "+this.size);
            if(this.size<=currentSmallest) currentSmallest = this.size;
            for (Directory d:directoriesIn) {
                if(d.size>=size){
                    long tempSize = d.sizeOfSmallestThatIsAtLeas(size,this.size);
                    if(tempSize<currentSmallest)currentSmallest = tempSize;
                }
            }
            return currentSmallest;
        }
    }

    public long calculateSize() {
        for (Directory d : directoriesIn) {
            this.size += d.calculateSize();
        }
        for (File f : filesIn) {
            this.size += f.size;
        }
        return this.size;
    }

    public Directory getInsideDirectoryByName(String name) {
        for (Directory d : directoriesIn) {
            if (d.name.equals(name)) return d;
        }
        return null;
    }

}
