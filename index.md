{% assign pages = site.pages | where_exp: "p", "p.path contains '.md'" | sort: "path" %}

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

<!-- <ul>
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
      {% comment %} This line now forces the filename (parts.last) instead of p.title {% endcomment %}
      <a href="{{ p.url }}">{{ parts.last | replace: ".md", "" | replace: "_", " " }}</a>
    </li>
  {% endunless %}
{% endfor %}
</ul> -->
<!-- <ul>
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
      {% comment %} This line now forces the filename (parts.last) instead of p.title {% endcomment %}
      <a href="{{ p.url }}">{{ parts.last | replace: ".md", "" | replace: "_", " " }}</a>
    </li>
  {% endunless %}
{% endfor %}
</ul> -->