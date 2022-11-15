package classes;

import java.util.List;

public class Table {
    private List<Fork> forks;

    public Table(List<Fork> forks) {
        this.forks = forks;
    }

    public List<Fork> getForks() {
        return this.forks;
    }

    public void putFork(int id, Fork fork) {
        // fork.setUsed(false);
        forks.set(id, fork);
    }

    public Fork getFork(int id) {
        // for (Fork fork : forks) {
        //     if (fork.getId() == id) {
        //         fork.setUsed(true);
        //         return fork;
        //     }
        // }
        Fork fork = forks.get(id);
        // forks.set(id, null);

        return fork;
    }
}
