package com.lab2.primitiveRepo;

import com.koloboke.collect.set.hash.HashIntSet;
import com.koloboke.collect.set.hash.HashIntSets;
import com.lab2.repository.InMemoryRepositoryPrimitive;
import org.eclipse.collections.api.set.MutableSet;

/**
 * Created by Cosmin on 12/11/2017.
 */
public class KolobokeHashSetRepo implements InMemoryRepositoryPrimitive {
    public HashIntSet set;

    public KolobokeHashSetRepo(){
        this.set = HashIntSets.getDefaultFactory().newMutableSet();
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
