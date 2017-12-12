package com.lab2.primitiveRepo;

import com.lab2.repository.InMemoryRepositoryPrimitive;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;

/**
 * Created by Cosmin on 12/11/2017.
 */
public class FastUtilHashSetRepo  implements InMemoryRepositoryPrimitive {

    private IntOpenHashSet set;

    public FastUtilHashSetRepo(){
        set = new IntOpenHashSet();
    }

    @Override
    public void add(int e) {
        set.add(e);
    }

    @Override
    public boolean contains(int e) {
        return set.contains(e);
    }

    @Override
    public void remove(int e) {
        set.remove(e);
    }

    @Override
    public void clear() {
        set.clear();
    }
}