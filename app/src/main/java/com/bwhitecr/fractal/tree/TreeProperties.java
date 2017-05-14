package com.bwhitecr.fractal.tree;

import android.databinding.Bindable;
import android.databinding.BaseObservable;

import com.bwhitecr.fractal.tree.BR;

/**
 * Copyright
 * <p/>
 * Created by bradwhitecross on 25/04/2016.
 */
public class TreeProperties extends BaseObservable {
    private int branches;
    private int bifurcations;

    public TreeProperties(int branches, int bifurcations) {
        this.branches = branches;
        this.bifurcations = bifurcations;
    }

    @Bindable
    public int getBranches(){
        return branches;
    }

    public void setBranches(int value) {
        branches = value;
        notifyPropertyChanged(BR.branches);
    }

    @Bindable
    public int getBifurcations() {
        return bifurcations;
    }

    public void setBifurcations(int value) {
        bifurcations = value;
        notifyPropertyChanged(BR.bifurcations);
    }
}
