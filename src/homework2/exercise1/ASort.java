package homework2.exercise1;

public abstract class ASort implements ISort {
    protected long operations = 0;
    protected long time = 0;

    @Override
    public long operations() {
        return operations;
    }

    @Override
    public long timeRun() {
        return time;
    }

    @Override
    public void print() {
        System.out.println();
    }
}
