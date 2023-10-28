package Iteration1.Implementation;

import java.util.List;

public interface IPairing<T,C> {
    protected List<T,C>[] registry = new List<T,C>[0];
}
