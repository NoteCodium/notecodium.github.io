<!-- <!-- {% assign pages = site.pages | where_exp: "p", "p.path contains '.md'" | sort: "path" %}

{% assign current_folder = "" %}

<ul>
{% for p in pages %}
  {% unless p.url == "/" %}
    {% assign parts = p.path | split: "/" %}
    {% assign folder = parts | slice: 0, parts.size | join: "/" | remove: parts.last %}

    {% if folder != current_folder %}
      {% if current_folder != "" %}
        </ul></li>
      {% endif %}
      <li>📂 <strong>{{ folder | default: "root" }}</strong>
        <ul>
      {% assign current_folder = folder %}
    {% endif %}

    <li>
      <a href="{{ p.url }}">{{ p.title | default: parts.last }}</a>
    </li>
  {% endunless %}
{% endfor %}
</ul></li>
</ul>
 -->
{% assign pages = site.pages | where_exp: "p", "p.path contains '.md'" | sort: "path" %}
{% assign current_folder = "" %}

<ul>
{% for p in pages %}
  {% unless p.url == "/" %}
    {% assign parts = p.path | split: "/" %}
    {% comment %} Reconstruct the folder path to maintain the nested structure logic {% endcomment %}
    {% assign folder = p.path | remove: parts.last %}

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
  {% endunless %}
{% endfor %}
</ul> -->

<!-- Make the contents of the subfolder hidden by a dropdown arrrow {% assign pages = site.pages | where_exp: "p", "p.path contains '.md'" | sort: "path" %} -->

{% assign current_folder = "" %}

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

{% endunless %}

{% endfor %}

</ul>