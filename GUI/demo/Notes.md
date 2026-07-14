### Visual Guide Swing components

https://web.mit.edu/6.005/www/sp14/psets/ps4/java-6-tutorial/components.html

### Visual Guide Swing layouts

https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html

### Google Search like -> java combobox 7 (java version)

https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html

---

## Component Addition Order

When adding a component to another component, follow this order:

1. **Create component** — Instantiate the object
2. **Set attributes** — Configure properties (size, layout, colors, etc.)
3. **Set eventListeners** — Attach behavior/interaction handlers
4. **Add to the component** — Place it into a container/parent

This ensures proper initialization and prevents issues with uninitialized properties when listeners fire.
