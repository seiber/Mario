package mario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Inventory 
{
		private Handler handler;
		private boolean active = false;
		private ArrayList<Item> inventoryItems;
		
		
		private int invX =64, invY =48,
		invWidth = 224, invHeight = 333,
		invListCenterX = invX + 116,
		invListCenterY = invY + invHeight / 2+5,
		invListSpacing = 30;
		
		private int invImageX = 300, invImageY = 180,
				invImageWidth = 64, invImageHeight=64;
		
		private int invCountX = 330, invCountY = 270;
		
		private int selectedItem =0 ;
		
		public Inventory (Handler handler)
		{
			this.handler = handler;
			inventoryItems = new ArrayList<Item>();
			//addItem(Item.presentItem.createNew(5));
			//addItem(Item.santaHat.createNew(3));
		}
		
		public void tick()
		{
				//opening or closing inventory
				if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
				{
					active = !active;
				}
				
				if (!active)
				{
					return;
				}
				
				
				if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_W))
				{
						selectedItem--;
				}
		
				if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_S))
				{
					selectedItem++;
				}
					
				if(selectedItem < 0)
				{
					selectedItem = inventoryItems.size() -1;
				}
				
				else if (selectedItem >= inventoryItems.size())
				{
					selectedItem = 0;
				}
				
			System.out.println("INV:");
			for (Item i :inventoryItems)
			{
				System.out.println(i.getName() + "   " + i.getCount());
			}
	}
		
		public void render(Graphics g)
		{
			if (!active)
				return;
			
			g.drawImage(Assets.inventoryScreen,invX,invY,invWidth,invHeight,null);
			
//			Text.drawString(g, "Selected item:",350,invListCenterY,true,Color.YELLOW,Assets.font28);
			
			int len = inventoryItems.size();
			if(len == 0)
				return;
			
			for (int i = -5; i < 6; i++)
			{
				if (selectedItem + i < 0 || selectedItem +i >= len)
				{
					continue;	
				}
				
				if (i ==0)
				{
					Text.drawString(g,"> "+ inventoryItems.get(selectedItem + i).getName()+ " <",invListCenterX,
						invListCenterY + i * invListSpacing,true,Color.YELLOW,Assets.font28);
				}
				else
				{
					Text.drawString(g, inventoryItems.get(selectedItem + i).getName(),invListCenterX,
							invListCenterY + i * invListSpacing,true,Color.WHITE,Assets.font28);
				}
			
			}
			
			Item item = inventoryItems.get(selectedItem);
			g.drawImage(item.getTexture(),invImageX,invImageY,invImageWidth,invImageHeight,null);
			Text.drawString(g, Integer.toString(item.getCount()),invCountX,invCountY, true,Color.BLACK,Assets.font28);
		}
		
		
		public void addItem(Item item)
		{
			for(Item i : inventoryItems)
			{
				if(i.getId() == item.getId())
				{
					i.setCount(i.getCount() + item.getCount());
					return;
				}
			}
			inventoryItems.add(item);
		}
		
		
		
		
		
		public Handler getHandler() 
		{
			return handler;
		}

		public void setHandler(Handler handler) 
		{
			this.handler = handler;
		}

		public boolean isActive() 
		{
			return active;
		}

		public void setActive(boolean active)
		{
			this.active = active;
		}

	
	
}
