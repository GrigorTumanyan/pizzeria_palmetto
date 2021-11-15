package homework3;

public class BlockingBuffer<T> {
    private T data;

    public T take() {
        synchronized (this) {
            while (this.data == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }

    public void put(T data) {
        synchronized (this){
            this.data = data;
            notifyAll();
        }
    }
}
