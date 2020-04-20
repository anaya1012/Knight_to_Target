import java.util.*;
class Coordinate
{
	int xpos;
	int ypos;
	Coordinate(int sp,int ep)
	{
		xpos=sp;
		ypos=ep;
	}
}
class KnT
{
	int xposk;
	int yposk;
	int xpost;
	int ypost;
	int cnt;
	int posx[]={-1,1,-2,2,-1,1,-2,2};
	int posy[]={-2,-2,-1,-1,2,2,1,1};
	KnT(int xposkn,int yposkn,int xpostarg,int ypostarg)
	{
		xposk=xposkn;
		yposk=yposkn;
		xpost=xpostarg;
		ypost=ypostarg;
		cnt=0;

	}
	boolean isinside(int x,int y)
	{
		if(x<=8 && x>0 && y<=8 && y>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	void cntsteps()
	{
		Queue<Coordinate> q=new LinkedList<Coordinate>();
		Coordinate c=new Coordinate(xposk,yposk);
		q.add(c);
		q.add(null);
		while(true)
		{
			Coordinate c1=q.remove();
			if(c1==null)
			{
				if(!q.isEmpty())
				{
					q.add(null);
				}

				cnt++;
			}
			else
			{
				if(c1.xpos==xpost && c1.ypos==ypost)
				{
					break;
				}
				else
				{

					for(int i=0;i<8;i++)
					{
						if(isinside(c1.xpos-posx[i],c1.ypos-posy[i]))
						{
							Coordinate c2=new Coordinate(c1.xpos-posx[i],c1.ypos-posy[i]);
							q.add(c2);
						}
					}


				}
			}
		}
	}
	void display()
	{
		System.out.println("Count is: "+cnt);
	}
}
public class Knight_1 {


	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int xk,yk;
		int xt,yt;
		int ch=0;
		KnT k;
		do
		{
			do
			{
				System.out.print("Enter x-cordinate of knight: ");
				xk=sc.nextInt();
				if(xk<0 || xk>8)
				{
					System.out.println("Enter a valid position");
				}
			}while(xk<=0 || xk>8);
			do
			{
				System.out.print("Enter y-ccordinate of knight: ");
				yk=sc.nextInt();
				if(yk<0 ||yk>8)
				{
					System.out.println("Enter a valid position");
				}

			}while(yk<0 ||yk>8);
			do
			{
				System.out.print("Enter x-coordinate of target: ");
				xt=sc.nextInt();
				if(xt<0 || xt>8)
				{
					System.out.println("Enter a valid position");
				}
			}while(xt<=0 || xt>8);
			do
			{
				System.out.print("Enter y-coordinate of target; ");
				yt=sc.nextInt();
				if(yt<0 ||yt>8)
				{
					System.out.println("Enter a valid position");
				}

			}while(yt<0 ||yt>8);
			k=new KnT(xk,yk,xt,yt);
			k.cntsteps();
			k.display();
			System.out.println("--------------------------------");
			System.out.println("Do you want to play again 1.Yes 2.No \nEnter choice");
			ch=sc.nextInt();
		}while(ch!=2);

	}



}
