package Day7;

public class FileSystem {
    Directory root = new Directory("/");
    Directory currentDir = root;

    public long getSizeSmallerThan(int size){
        return root.sizeOfthisAndBelowFoldersSmallerThan(size);
    }

    public void processLine(String line) {
        String[] commands = line.split(" ");
        switch (commands[0]) {
            case "$":
                switch (commands[1]) {
                    case "cd":
                        if (commands[2].equals("/")) {
                            currentDir = root;
                        } else if (commands[2].equals("..")) {
                            currentDir = currentDir.myParent;
                        } else {
                            currentDir = currentDir.getInsideDirectoryByName(commands[2]);

                        }
                        break;
                    case "ls":
                        break;
                }
                break;
            case "dir":
                currentDir.directoriesIn.add(new Directory(commands[1]));
                currentDir.directoriesIn.get(currentDir.directoriesIn.size() - 1).myParent = currentDir;
                break;
            default:
                currentDir.filesIn.add(new File(Integer.parseInt(commands[0]), commands[1]));
                break;
        }
    }
}
