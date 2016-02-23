import java.util.ArrayList;

/*
 * Selection Sorter class
 * @author Bryan Sugiarto
 * @version lab10
 */

public class BinarySearcher
        {
            private ArrayList<String>a;

            public BinarySearcher(ArrayList<String>a)
            {
                this.a = a;
            }

            public int search(String value)
            {
                int lo = 0;
                int hi = a.size() - 1;

                while (lo <= hi)
                {
                    int mid = (lo + hi) / 2;
             
                    if (value.compareTo(a.get(mid))<0)
                    {
                        hi = mid - 1;
                    }
                    else if (value.compareTo( a.get(mid))>0)
                    {
                        lo = mid + 1;
                    }
                    else
                    {
                        return mid;
                    }
                }

                return -1;
            }
        } // End of class