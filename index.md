{% assign pages = site.pages | where_exp: "p", "p.path contains '.md'" | sort: "path" %} {% assign current_folder = "" %}

{% for p in pages %} {% unless p.url == "/" %} {% assign parts = p.path | split: "/" %} {% comment %} Reconstruct the folder path to maintain the nested structure logic {% endcomment %} {% assign folder = p.path | remove: parts.last %}
{% if folder != current_folder %}
  {% if current_folder != "" %}
    </ul></li>
  {% endif %}
  <li>📂 <strong>{{ folder | default: "root" }}</strong>
    <ul>
  {% assign current_folder = folder %}
{% endif %}

<li>
  {% comment %} 
     Using parts.last ensures the filename (e.g., 3Data_Transformation.md) 
     is shown even if there is a # discretization heading inside.
  {% endcomment %}
  <a href="{{ p.url }}">{{ parts.last }}</a>
</li>
{% endunless %} {% endfor %}