import java.util.*;
class node
{
	node next;
	int start;
	int end;
	node(int st,int en)
	{
		next=null;
		start=st;
		end=en;
	}
}
class list
{
	int nv;
	node head[]=new node[50];
	void insert(int strt,int end,int i)
	{
		node temp=new node(strt,end);
		if(head[i]==null)
		{
			head[i]=temp;
		}
		else
		{
			node ptr=head[i];
			while(ptr.next!=null)
			{
				ptr=ptr.next;
			}
			ptr.next=temp;
		}
	}
	int cntsteps(int spk,int endk,int spt,int endt)
	{
		Queue<node> q=new LinkedList<node>();
		int visited[][]=new int[8][8];
		visited[spk-1][endk-1]=1;
		node ptr=new node(spk,endk);
		node ptr1=new node(50,50);
		int i=0;
		int cnt=0;
		q.add(ptr);
		q.add(ptr1);
		while(!q.isEmpty())
		{
			ptr=q.remove();
			if(ptr.start!=50 && ptr.end!=50)
			{
				
			
					if(ptr.start-1<=8 && ptr.start-1>0 && ptr.end-2<=8 && ptr.end-2>0)		//Move doesn't exceed chessboard
					{
						insert(ptr.start-1,ptr.end-2,i);
						
					}
					if(ptr.start+1<=8 && ptr.start+1>0 && ptr.end-2<=8 && ptr.end-2>0)		//Move doesn't exceed chessboard
					{
						insert(ptr.start+1,ptr.end-2,i);
					}
					if(ptr.start-2<=8 && ptr.start-2>0 && ptr.end-1<=8 && ptr.end-1>0)		//Move doesn't exceed chessboard
					{
						insert(ptr.start-2,ptr.end-1,i);
					}
					if(ptr.start+2<=8 && ptr.start+2>0 && ptr.end-1<=8 && ptr.end-1>0)		//Move doesn't exceed chessboard
					{
						insert(ptr.start+2,ptr.end-1,i);
					}
					if(ptr.start-1<=8 && ptr.start-1>0 && ptr.end+2<=8 && ptr.end+2>0)		//Move doesn't exceed chessboard
					{
						insert(ptr.start-1,ptr.end+2,i);
						
					}
					if(ptr.start+1<=8 && ptr.start+1>0 && ptr.end+2<=8 && ptr.end+2>0)		//Move doesn't exceed chessboard
					{
						insert(ptr.start+1,ptr.end+2,i);
					}
					if(ptr.start-2<=8 && ptr.start-2>0 && ptr.end+1<=8 && ptr.end+1>0)		//Move doesn't exceed chessboard
					{
						insert(ptr.start-2,ptr.end+1,i);
					}
					if(ptr.start+2<=8 && ptr.start+2>0 && ptr.end+1<=8 && ptr.end+1>0)		//Move doesn't exceed chessboard
					{
						insert(ptr.start+2,ptr.end+1,i);
					}
				
				ptr=head[i];
				while(ptr!=null)
				{
					//System.out.println(ptr.start);
					//System.out.println(ptr.end);
					if(visited[(ptr.start)-1][(ptr.end)-1]!=1)
					{
						if(ptr.start==spt && ptr.end==endt)
						{
							break;
						}
						q.add(ptr);
						visited[(ptr.start)-1][(ptr.end)-1]=1;
					}
					ptr=ptr.next;
				}
				if(ptr!=null)
				{
					break;
				}
				i++;
				//System.out.println(i);
			}
			else
			{
				cnt++;
				q.add(ptr1);
			}
		}
		return cnt;
	}
}

public class Knight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int xk,yk;
		int xt,yt;
		int ch=0;
		list l=new list();
		do
		{
			System.out.print("Enter x-cordinate of knight: ");
			xk=sc.nextInt();
			System.out.print("Enter y-ccordinate of knight: ");
			yk=sc.nextInt();
			System.out.print("Enter x-coordinate of target: ");
			xt=sc.nextInt();
			System.out.print("Enter y-coordinate of target; ");
			yt=sc.nextInt();
			int cnt=l.cntsteps(xk, yk, xt, yt);
			System.out.println("Count of the steps is "+(cnt+1));
			System.out.println("--------------------------------");
			System.out.println("Do you want to play again 1.Yes 2.No \nEnter choice");
			ch=sc.nextInt();
		}while(ch!=2);

	}

}
