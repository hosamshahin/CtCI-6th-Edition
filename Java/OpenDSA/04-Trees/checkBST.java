static boolean checkBST(BSTNode rt,Comparable low,Comparable high){
    if(rt == null){
    // Empty subtree
    return true;
    }
    Comparable rootval=rt.value();
    if((rootval.compareTo(low)<=0)||(rootval.compareTo(high)>0)){
    // Out of range
    return false;
    }

    if(!checkBST(rt.left(),low,rootval)){
    // Left side failed
    return false;
    }

    return checkBST(rt.right(),rootval,high);
}